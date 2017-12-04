# DAY 1

## Weather App
A simple app that uses volley library to fetch JSON data from an API. Enter the city name and it'll show the weather type.

## API 
openweathermap.org provides an great API which is simple, clear and free. There are various options to choose from, like what type of data you want to fetch. This app provides you with the realtime weather updates.

## Volley Library

Volley is an HTTP library that makes networking for Android apps easier and most importantly, faster. Volley is available on GitHub.

Volley offers the following benefits:

- Automatic scheduling of network requests.
- Multiple concurrent network connections.
- Transparent disk and memory response caching with standard HTTP cache coherence.
- Support for request prioritization.
- Cancellation request API. 

Volley is not suitable for large download or streaming operations, since Volley holds all responses in memory during parsing. For large download operations, consider using an alternative like DownloadManager.

### Add Volley to your project

Add the following dependency to your app's build.gradle file:
```dependencies {
    compile 'com.android.volley:volley:1.0.0'
}```


You can also clone the Volley repository and set it as a library project:

```Git clone the repository by typing the following at the command line:
    git clone https://github.com/google/volley```

-Import the downloaded source into your app project as an Android library module as described in Create an Android Library.

