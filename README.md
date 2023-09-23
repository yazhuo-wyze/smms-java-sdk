#### this a free drawing bed.

#### from : https://sm.ms/

#### this code repo is https://doc.sm.ms java sdk achieve.

### used

#### Install 1/2: Add this to pom.xml:

```xml

<dependency>
  <groupId>io.github.yazhuo-wyze</groupId>
  <artifactId>smms-java-sdk</artifactId>
  <version>1.0.6</version>
</dependency>
```

#### Install 2/2: Run via command line

```shell
mvn install
```

### code used

```java
// new client
final SMMSClient smmsClient = new SMMSClient("SMMS_API_TOKEN");
//or 
final SMMSClient smmsClient = new SMMSClient("USERNAME","PASSWORD");

// get user profile
final ResponseUserProfile profile=this.smmsClient.profile();

// pic upload
final ImageItem imageItem = smmsClient.upload(FileUtil.file("lina.jpg"));
final String url = imageItem.getUrl();
final String hash = imageItem.getHash();

// list current user upload history
final List<ImageItem> imageItems=this.smmsClient.uploadHistory();

// pic delete 
final Boolean delete = this.smmsClient.delete(imageItem.getHash());

```
