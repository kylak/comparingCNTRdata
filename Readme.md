Here is a command to download the public CNTR collation : 
```
javac UpdateData.java -d Diverse/Generated\ Java\ classes/ && cd Diverse/Generated\ Java\ classes/ && java UpdateData && sh .downloadData  && rm .downloadData && cd ../
```
The CNTR downloaded files are located on ```/Data/CNTR/$TODAYSDATE$```