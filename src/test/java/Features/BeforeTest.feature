Feature: DB connection call
  Scenario:
    * def dbUtil = Java.type('Utils.DbUtils')
    * def dbCon = dbUtil.createDBConnection()
