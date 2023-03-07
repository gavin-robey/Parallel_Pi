# Parallel Pi 

## Project Information
This program computes the first 1000 digits of pi using the Bailey-Borwein-Plouffe Formula. The computational power needed to compute each digit is then split into seperate threads running on each core of the machine using this program. Each digit to be computed is pulled from a FIFO queue, then once complete, the computed digit of pi is placed into a hash map.

## Build Instructions


1. Build file by running the following command:
```
$ gradle build
```
2. Then run the program using: 
```
$ java -jar build/libs/*.jar
```

## Expected output: 

```
Executing using 8 cores
 
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706
7982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381
9644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412
7372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160
9433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949
1298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051
3200056812714526356082778577134275778960917363717872146844090122495343014654958537105079227968925892
3542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318
5950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473
0359825349042875546873115956286388235378759375195778185778053217122680661300192787661119590921642019
89
 
Time taken: 3827ms

```
