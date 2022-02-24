Feature: Read from database

  Scenario:
    * def DbUtils = Java.type('Utils.DbUtils')
    * def db = new DbUtils()
    * def query1 = function(id){ return db.readRowDB('SELECT * FROM "public"."" where "id" = \''++'\'') }
