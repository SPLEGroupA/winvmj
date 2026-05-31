INSERT INTO auth_user_comp (id) VALUES ('b097505f-be60-414b-83a8-cf4f44bc30ed') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_impl (id,allowedPermissions,name,email)
VALUES ('b097505f-be60-414b-83a8-cf4f44bc30ed','','Admin','admin@user.com')
ON CONFLICT (id) DO UPDATE SET
  allowedPermissions = EXCLUDED.allowedPermissions,
  name = EXCLUDED.name,
  email = EXCLUDED.email;

INSERT INTO auth_user_passworded (id,password,record_id)
VALUES (
  'b097505f-be60-414b-83a8-cf4f44bc30ed',
  '34a02225233fdf7fb0fe621c0f74058047069dad35fb413f93f4e65a73774e52019e800fbc57a3db589942cec07108bdd38c6aa0fa11253ea08718a9ec9c687d',
  'b097505f-be60-414b-83a8-cf4f44bc30ed'
)
ON CONFLICT (id) DO UPDATE SET
  password = EXCLUDED.password,
  record_id = EXCLUDED.record_id;

INSERT INTO auth_role_comp (id) VALUES ('75f6727e-66f8-484f-b77f-83eeec82cd10') ON CONFLICT DO NOTHING;

INSERT INTO auth_role_impl (id,name,allowedPermissions)
VALUES ('75f6727e-66f8-484f-b77f-83eeec82cd10','admin','administrator')
ON CONFLICT (id) DO UPDATE SET
  name = EXCLUDED.name,
  allowedPermissions = EXCLUDED.allowedPermissions;

INSERT INTO auth_user_role_comp (id) VALUES ('118fac06-f754-4c36-bf92-7213a1a08c56') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_impl (id,authRole,authUser)
VALUES (
  '118fac06-f754-4c36-bf92-7213a1a08c56',
  '75f6727e-66f8-484f-b77f-83eeec82cd10',
  'b097505f-be60-414b-83a8-cf4f44bc30ed'
)
ON CONFLICT (id) DO UPDATE SET
  authRole = EXCLUDED.authRole,
  authUser = EXCLUDED.authUser;
