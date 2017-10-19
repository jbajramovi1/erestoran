# --- !Ups
ALTER TABLE account ADD UNIQUE (email);
# --- !Downs
