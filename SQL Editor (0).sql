create table "robot_attachment"  (
   "atid"               INTEGER                         not null,
   "atname"             VARCHAR2(20)                    not null,
   constraint PK_ROBOT_ATTACHMENT primary key ("atid")
);

create table "robot_letter"  (
   "lid"                INTEGER                         not null,
   "adid"               INTEGER,
   "ltitle"             VARCHAR2(100)                   not null,
   "lcontent"           CLOB                            not null,
   "ldate"              DATE                            not null,
   constraint PK_ROBOT_LETTER primary key ("lid")
);

create table "robot_news"  (
   "nid"                INTEGER                         not null,
   "atid"               INTEGER,
   "adid"               INTEGER,
   "mtitle"             VARCHAR2(100)                   not null,
   "mdate"              DATE                            not null,
   "mcontent"           CLOB                            not null,
   "mattachment"        VARCHAR2(1024),
   "mtop"               INTEGER,
   constraint PK_ROBOT_NEWS primary key ("nid")
);

create table "team_admin"  (
   "adid"               INTEGER                         not null,
   "aid"                INTEGER,
   "adname"             VARCHAR2(20)                    not null,
   "adpwd"              VARCHAR2(20)                    not null,
   "ademail"            VARCHAR2(50),
   constraint PK_TEAM_ADMIN primary key ("adid")
);

create table "team_application"  (
   "appid"              INTEGER                         not null,
   "tid"                INTEGER,
   "itid"               INTEGER,
   "appsum"             INTEGER,
   "appnum"             INTEGER,
   "appstate"           INTEGER,
   constraint PK_TEAM_APPLICATION primary key ("appid")
);

create table "team_area"  (
   "aid"                INTEGER                         not null,
   "aname"              VARCHAR2(40)                    not null,
   constraint PK_TEAM_AREA primary key ("aid")
);

create table "team_items"  (
   "itid"               INTEGER                         not null,
   "itname"             VARCHAR2(50)                    not null,
   "itlimit"            INTEGER,
   "itremark"           VARCHAR2(1024),
   constraint PK_TEAM_ITEMS primary key ("itid")
);

create table "team_letter"  (
   "leid"               INTEGER                         not null,
   "lid"                INTEGER,
   "tid"                INTEGER,
   "lestate"            INTEGER                         not null,
   constraint PK_TEAM_LETTER primary key ("leid")
);

create table "team_members"  (
   "mid"                INTEGER                         not null,
   "tid"                INTEGER,
   "mname"              VARCHAR2(20)                    not null,
   "mgender"            CHAR(2)                         not null,
   "mphone"             VARCHAR2(15)                    not null,
   "memail"             VARCHAR2(50),
   "mtype"              VARCHAR2(10),
   "mleader"            INTEGER,
   "mremark"            VARCHAR2(1024),
   constraint PK_TEAM_MEMBERS primary key ("mid")
);

create table "team_unversity"  (
   "sid"                INTEGER                         not null,
   "aid"                INTEGER,
   "sname"              VARCHAR2(50)                    not null,
   constraint PK_TEAM_UNVERSITY primary key ("sid")
);

create table "team_user"  (
   "tid"                INTEGER                         not null,
   "sid"                INTEGER,
   "tname"              VARCHAR2(20)                    not null,
   "tpwd"               CHAR(20)                        not null,
   "temail"             VARCHAR2(50),
   "tremark"            VARCHAR2(1024),
   constraint PK_TEAM_USER primary key ("tid")
);


alter table "robot_letter"
   add constraint FK_ROBOT_LE_ADMIN_LET_TEAM_ADM foreign key ("adid")
      references "team_admin" ("adid");

alter table "robot_news"
   add constraint FK_ROBOT_NE_ADMIN_NEW_TEAM_ADM foreign key ("adid")
      references "team_admin" ("adid");

alter table "robot_news"
   add constraint FK_ROBOT_NE_ATTACHMEN_ROBOT_AT foreign key ("atid")
      references "robot_attachment" ("atid");

alter table "team_admin"
   add constraint FK_TEAM_ADM_AREA_ADMI_TEAM_ARE foreign key ("aid")
      references "team_area" ("aid");

alter table "team_application"
   add constraint FK_TEAM_APP_APPLICATI_TEAM_ITE foreign key ("itid")
      references "team_items" ("itid");

alter table "team_application"
   add constraint FK_TEAM_APP_APPLICATI_TEAM_USE foreign key ("tid")
      references "team_user" ("tid");

alter table "team_letter"
   add constraint FK_TEAM_LET_SEND_LETT_ROBOT_LE foreign key ("lid")
      references "robot_letter" ("lid");

alter table "team_letter"
   add constraint FK_TEAM_LET_USER_LETT_TEAM_USE foreign key ("tid")
      references "team_user" ("tid");

alter table "team_members"
   add constraint FK_TEAM_MEM_USER_MEMB_TEAM_USE foreign key ("tid")
      references "team_user" ("tid");

alter table "team_unversity"
   add constraint FK_TEAM_UNV_AREA_SCHO_TEAM_ARE foreign key ("aid")
      references "team_area" ("aid");

alter table "team_user"
   add constraint FK_TEAM_USE_SCHOOL_TE_TEAM_UNV foreign key ("sid")
      references "team_unversity" ("sid");
