delete from `p_module` where name='图片中心';
INSERT INTO `p_module`(id,name,flag,url,sort_no,create_person,create_date,update_person,update_date) 
VALUES
(2,'图片中心','pi','http://127.0.0.1:10003/picture-server',20,'system',NOW(),'system',NOW())
;


delete from `p_resource` where module_flag='pi';
INSERT INTO `p_resource`(id,name,url,remark,parent_id,structure,sort_no,module_flag,create_person,create_date,update_person,update_date) 
VALUES
(5,'图片浏览','/controller/view.do','',0,'s-1',1,'pi','system',NOW(),'system',NOW()),
(6,'图片上传','/controller/upload.do','',0,'s-2',2,'pi','system',NOW(),'system',NOW())
;