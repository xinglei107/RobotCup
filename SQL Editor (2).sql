
    select
        "ATID",
        "ATNAME" 
    from
        "ROBOT"."ROBOT_ATTACHMENT"
        
        select it.itname, un.sname, ue.tname from team_application ap, team_items it, team_unversity un, team_user ue where ap.itid=it.itid and ap.tid=ue.tid and ue.sid=un.sid order by un.sname,it.itname,ue.tname
        select count(*),it.itname from team_application ap, team_items it, team_unversity un, team_user ue where ap.itid=it.itid and ap.tid=ue.tid and ue.sid=un.sid and un.sname='������Ϣ�Ƽ���ѧ' and it.itname='�赸�������������' and ap.appyear=2016 group by un.sname,it.itname,ap.appyear
         
        select * from team_application where appyear=2016