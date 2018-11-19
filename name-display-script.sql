SET SCHEMA 'project-1';

SELECT  reimb_id, r.reimb_author, r.reimb_resolver, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status, reimb_type, r.reimb_status_id, r.reimb_type_id
FROM ers_users u
inner join ers_reimbursement r
on u.ers_users_id = r.reimb_author
inner join ers_reimbursement_status s
on r.reimb_status_id = s.reimb_status_id
inner join ers_reimbursement_type ty
on r.reimb_type_id = ty.reimb_type_id