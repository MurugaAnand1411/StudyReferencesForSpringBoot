INSERT INTO public.roles(
	id, name)
	VALUES (1, 'ROLE_EMPLOYEE');
INSERT INTO public.roles(
	id, name)
	VALUES (2, 'ROLE_ADMIN');
INSERT INTO public.roles(
	id, name)
	VALUES (3, 'ROLE_TL');
INSERT INTO public.roles(
	id, name)
	VALUES (4, 'ROLE_TA');	
	
INSERT INTO public.employee(
	employee_id,email_id, firstname, mobileno, password, verification_code, verified)
	VALUES (1,'dinesh@rubixtek.com', 'Dinesh','346575859505','$2a$04$LAdeX/TCMEjFMW4yHb1ogOE/3aLUt1ZdO9gvsoiqcFMaEwv38S.C6','eoR0mtCcm2wjg2iqm6nhrDV4aND4yr5eH9mgNftEh7sHnrbWegGTOcukI6zZQm3s',true);


INSERT INTO public.employee_roles(
	employee_id, role_id)
	VALUES (1, 2);
	
INSERT INTO public.employee(
	employee_id,email_id, firstname, mobileno, password, verification_code, verified)
	VALUES (2,'raam@rubixtek.com', 'Raam','346575859505','$2a$04$WmBtmMjWsYpp2GXh3Gb1Degxe/6J0bGLjhwBcbUED7JW488Xtl.bC','eoR0mtCcm2wjg2iqm6nhrDV4aND4yr5eH9mgNftEh7sHnrbWegGTOcukI6zZQm3s',true);


INSERT INTO public.employee_roles(
	employee_id, role_id)
	VALUES (2, 2);
	
INSERT INTO public.employee(
	employee_id,email_id, firstname, mobileno, password, verification_code, verified)
	VALUES (3,'karthik@rubixtek.com', 'Karthik','346575859505','$2a$04$r0ioMjFCxBydKu4fF07YPekJ3/uqyPv3sgD5uyUBcTh4coWipYPA6','eoR0mtCcm2wjg2iqm6nhrDV4aND4yr5eH9mgNftEh7sHnrbWegGTOcukI6zZQm3s',true);


INSERT INTO public.employee_roles(
	employee_id, role_id)
	VALUES (3, 2);
	
INSERT INTO public.employee(
	employee_id,email_id, firstname, mobileno, password, verification_code, verified)
	VALUES (4,'baskar@rubixtek.com', 'Baskar','346575859505','$2a$04$GshnbQwxHFEVgHmAVad/ouKYKXu0DavLogifhkmKsXdOtDMEzUIbS','eoR0mtCcm2wjg2iqm6nhrDV4aND4yr5eH9mgNftEh7sHnrbWegGTOcukI6zZQm3s',true);


INSERT INTO public.employee_roles(
	employee_id, role_id)
	VALUES (4, 2);