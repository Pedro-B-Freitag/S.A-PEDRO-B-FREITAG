ALTER TABLE curso
Drop column curso_presencial;
ALTER TABLE curso
add curso_presencial BOOLEAN not null;
update curso set curso_presencial = true;