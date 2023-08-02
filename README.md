# FabbrickTest
Per invocare l'endpoint della lettura saldo: 
GET : http://localhost:8080/balanceReading/14537781

Per invocare l'endpoint della lista di transazioni: 
GET : http://localhost:8080/readingTransaction/14537780/[?<uriQuery>] ovvero ---> : http://localhost:8080/readingTransaction/14537780?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01 

Per invocare l'endpoint del bonifico:
POST : http://localhost:8080/moneyTransfer/14537780
