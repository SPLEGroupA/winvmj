#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE tokoonlineanime_product_anisecond' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'tokoonlineanime_product_anisecond') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/tokoonlineanime_product_anisecond"
done

java -cp tokoonlineanime.product.anisecond --module-path tokoonlineanime.product.anisecond -m tokoonlineanime.product.anisecond &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait