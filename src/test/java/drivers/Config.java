package drivers;

@Config.Sources({"classpath:config/remote.properties"})
public interface Config extends org.aeonbits.owner.Config {
    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();

}
