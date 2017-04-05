package sqlTools;

public class Sql {
	/**
	只显示列
	select GROUP_CONCAT(COLUMN_NAME) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'
	id,user_id,content,active_id,create_time,phone,user_name
	-- 有别名
	select GROUP_CONCAT(CONCAT('t.',COLUMN_NAME)) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'



	只显示插入注入的value值
	select GROUP_CONCAT(concat('#{',COLUMN_NAME,'}')) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'
	#{id},#{user_name},#{active_id},#{user_id},#{create_time},#{is_sign},#{remark},#{sex},#{card_number},#{mobile},#{company},#{age}




	只显示更新注入value值
	SELECT GROUP_CONCAT(CONCAT(COLUMN_NAME,'=#{',COLUMN_NAME,'}')) from  information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'

	id=#{id},user_id=#{user_id},content=#{content},active_id=#{active_id},create_time=#{create_time},phone=#{phone},user_name=#{user_name}

	显示完整sql

	select concat('select ',GROUP_CONCAT(concat('t.',COLUMN_NAME)),' from e_active_feedback',' t') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2';

	select t.id,t.user_id,t.content,t.active_id,t.create_time,t.phone,t.user_name from e_active_feedback t

	-- 没有别名
	select concat('select ',GROUP_CONCAT(COLUMN_NAME),' from e_active_feedback') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2';

	select id,user_id,content,active_id,create_time,phone,user_name from e_active_feedback

	-- 插入语句
	SELECT 
	CONCAT(
	'insert into ',
	'e_active_feedback (',
	(select GROUP_CONCAT(COLUMN_NAME) from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'),
	')values(',
	(select GROUP_CONCAT(concat(concat('#{',COLUMN_NAME)),'}') from information_schema.COLUMNS where table_name = 'e_active_feedback' and table_schema = 'ehome2'),
	')'
	) as 插入语句
	from dual
	insert into e_active_feedback (id,user_id,content,active_id,create_time,phone,user_name)values(#{id},#{user_id},#{content},#{active_id},#{create_time},#{phone},#{user_name})

	-- 更新语句
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



	-- 删除
	SELECT CONCAT('delete from ',
	'e_active_feedback',
	' where 1=1 '
	,' and id=#{id}')
	from dual

	delete from e_active_feedback where 1=1  and id=#{id}
	**/
}
