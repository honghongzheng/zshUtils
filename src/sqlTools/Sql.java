package sqlTools;

public class Sql {
	/**
	ֻ��ʾ��
	select GROUP_CONCAT(COLUMN_NAME) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'
	id,user_id,content,active_id,create_time,phone,user_name
	-- �б���
	select GROUP_CONCAT(CONCAT('t.',COLUMN_NAME)) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'



	ֻ��ʾ����ע���valueֵ
	select GROUP_CONCAT(concat('#{',COLUMN_NAME,'}')) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'
	#{id},#{user_name},#{active_id},#{user_id},#{create_time},#{is_sign},#{remark},#{sex},#{card_number},#{mobile},#{company},#{age}




	ֻ��ʾ����ע��valueֵ
	SELECT GROUP_CONCAT(CONCAT(COLUMN_NAME,'=#{',COLUMN_NAME,'}')) from  information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'

	id=#{id},user_id=#{user_id},content=#{content},active_id=#{active_id},create_time=#{create_time},phone=#{phone},user_name=#{user_name}

	��ʾ����sql

	select concat('select ',GROUP_CONCAT(concat('t.',COLUMN_NAME)),' from e_active_feedback',' t') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2';

	select t.id,t.user_id,t.content,t.active_id,t.create_time,t.phone,t.user_name from e_active_feedback t

	-- û�б���
	select concat('select ',GROUP_CONCAT(COLUMN_NAME),' from e_active_feedback') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2';

	select id,user_id,content,active_id,create_time,phone,user_name from e_active_feedback

	-- �������
	SELECT 
	CONCAT(
	'insert into ',
	'e_active_feedback (',
	(select GROUP_CONCAT(COLUMN_NAME) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'),
	')values(',
	(select GROUP_CONCAT(concat(concat('#{',COLUMN_NAME)),'}') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'),
	')'
	) as �������
	from dual
	insert into e_active_feedback (id,user_id,content,active_id,create_time,phone,user_name)values(#{id},#{user_id},#{content},#{active_id},#{create_time},#{phone},#{user_name})

	-- �������
	SELECT 
	CONCAT(
	'update e_active_feedback set ',
	' ',
	(SELECT GROUP_CONCAT(CONCAT(COLUMN_NAME,'=#{',COLUMN_NAME,'}')) from  information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'
	),
	' where 1=1'
	,' and id =#{id}')
	from dual

	update e_active_feedback set  id=#{id},user_id=#{user_id},content=#{content},active_id=#{active_id},create_time=#{create_time},phone=#{phone},user_name=#{user_name} where 1=1 and id =#{id}



	-- ɾ��
	SELECT CONCAT('delete from ',
	'e_active_feedback',
	' where 1=1 '
	,' and id=#{id}')
	from dual

	delete from e_active_feedback where 1=1  and id=#{id}
	**/
}
