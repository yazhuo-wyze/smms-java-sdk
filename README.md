#### this a free drawing bed.

#### from : https://sm.ms/

#### this code repo is https://doc.sm.ms java sdk achieve.

### used

#### Install 1/2: Add this to pom.xml:

```xml

<dependency>
    <groupId>com.github.yazhuo-hihi</groupId>
    <artifactId>smms-java-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```

#### Install 2/2: Run via command line

```shell
mvn install
```

### code used

```java

final SMMSClient smmsClient = new SMMSClient("SMMS_API_TOKEN");
or 
final SMMSClient smmsClient = new SMMSClient("USERNAME","PASSWORD");


// pic upload
final ImageItem imageItem = smmsClient.upload(FileUtil.file("lina.jpg"));
final String url = imageItem.getUrl();
final String hash = imageItem.getHash();

// pic delete 
final Boolean delete = this.smmsClient.delete(imageItem.getHash());

```
