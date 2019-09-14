# exchange
Demo project


Application Name   Conversion

Purpose    To display USD-PLN currency relation by fetching data from a remote repo and update the PLN value in every minute. 

Date  14 Sept, 2019

Solution     For this I make a simple application which fetch the exchange rates from remote repository URL: https://api.exchangeratesapi.io/latest

Having response like: 
{"rates":{"CAD":1.4663,"HKD":8.6832,"ISK":138.1,"PHP":57.644,"DKK":7.4678,"HUF":331.53,"CZK":25.843,"AUD":1.6126,"RON":4.7352,"SEK":10.6485,"IDR":15495.56,"INR":78.7415,"BRL":4.4964,"RUB":71.2243,"HRK":7.3945,"JPY":119.83,"THB":33.776,"CHF":1.094,"SGD":1.5226,"PLN":4.3248,"BGN":1.9558,"TRY":6.2892,"CNY":7.8589,"NOK":9.9213,"NZD":1.7354,"ZAR":16.0983,"USD":1.1096,"MXN":21.507,"ILS":3.9133,"GBP":0.89093,"KRW":1306.0,"MYR":4.6209},"base":"EUR","date":"2019-09-13"}

In this I assumed that data will be fetched whenever the API be fetched. So, the proper error handling for remote data fetching has not been added. 

The timer here I used Countdown timer, there are some other ways too, like Handler, but t moment seeking time in mind, tried to keep things simple.
            
