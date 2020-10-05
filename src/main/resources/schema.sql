create table category (id bigint, description varchar(255) not null, type_id bigint, parent_id bigint, primary key (id));
alter table category add constraint FK_PARENT_CATEGORY foreign key (parent_id) references category;
