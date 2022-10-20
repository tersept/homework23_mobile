package drivers;
@Config.Sources({"classpath:config/remote.properties"})
public interface Config extends org.aeonbits.owner.Config {
    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();
    @Key("app")
    String getApp();

    @Key("remoteUrl")
    String getRemoteUrl();

}
