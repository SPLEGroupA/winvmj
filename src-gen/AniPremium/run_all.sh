#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE tokoonlineanimepl_product_anipremium' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'tokoonlineanimepl_product_anipremium') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/tokoonlineanimepl_product_anipremium"
done

java -cp tokoonlineanimepl.product.anipremium --module-path tokoonlineanimepl.product.anipremium -m tokoonlineanimepl.product.anipremium &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait