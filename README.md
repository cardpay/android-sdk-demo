Unlimint SDK
========
Try Demo now https://appdistribution.firebase.dev/i/fd06677d71f4734f
========

## Requirements

- Android 4.4+

## Installation
```ruby
repositories {
    ...
    
    maven { url "https://repos.unlimint.io/repository/mobile-sdk/" }
}
dependencies {
    ...
    implementation "com.unlimint.sdk:mobile-sdk:$sdk_version"
    ...
}
``` 
#### Using

```ruby
MobileSdk.bindNewCardForResult(...) //for bankcard binding 
MobileSdk.paymentForResult(...) //for payment
MobileSdk.paymentForResult(saveCard, ...) //for saved card payment

fun onActivityResult(...) // wait for result here
``` 

## Documentation

- [Technical documents](./Docs).

## Contribution Guide

A guide to [submit issues](https://github.com/cardpay/android-sdk-demo/issues), to ask general questions, or to [open pull requests](https://github.com/cardpay/android-sdk-demo/pulls).
