//[sdk](../../../index.md)/[com.unlimint.sdk.api.model](../index.md)/[Customer](index.md)/[workPhone](work-phone.md)



# workPhone  
[androidJvm]  
Content  
val [workPhone](work-phone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null  
More info  


The work phone number provided by the Cardholder. Required (if available) unless market or regional mandate restricts sending this information. Characters format: recommended to send phone number in following format "+1 111111111" with country code and subscriber sections (only digits are accepted) of the number, "+" as prefix and "space" as delimiter. Refer to ITU-E.164 for additional information on format and length. Field will be ignored if filing.id is presented in request (continue one-click scenario)

  



