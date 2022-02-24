function(){
    var System = Java.type('java.lang.System')
    var env = karate.env;
    karate.log('karate.env system property was:', env);
    if (!env){
        env = 'QA';
    }
   var config = {
   ymlFile : karate.read('classpath:Config/configuration.yml')
    }
//      config.baseUrlApiLayer = config.ymlFile.baseUrlApiLayer
      System.setProperty("karate.url",config.ymlFile.dbUrl)
      System.setProperty("karate.username",config.ymlFile.username)
      System.setProperty("karate.password",config.ymlFile.password)
      System.setProperty("karate.DriverClassName",config.ymlFile.DriverClassName)
      karate.callSingle("classpath:Features/CommonFeature/BeforeTest.feature",config);
    return config;
}
