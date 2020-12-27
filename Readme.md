Here is a command to download the public CNTR collation : 
```
javac UpdateData.java -d Diverse/Generated\ Java\ classes/ && cd Diverse/Generated\ Java\ classes/ && java UpdateData && sh .downloadData  && rm .downloadData && cd ../
```
The CNTR downloaded files are located on ```/Data/CNTR/$TODAYSDATE$```

Here is a command to download others data than the CNTR ones : 
```
javac dataToTest.java -d Diverse/Generated\ Java\ classes/ && cd Diverse/Generated\ Java\ classes/ && java dataToTest && sh .downloadDataToCompare  && rm .downloadDataToCompare && cd ../..
```
These datas files are located on ```/Data/dataToTest/$TODAYSDATE$```