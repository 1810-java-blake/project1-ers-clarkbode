SET SCHEMA 'project-1';

SELECT  reimb_id, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status_id, reimb_type_id
FROM ers_users u
inner join ers_reimbursement r
on u.ers_users_id = r.reimb_author