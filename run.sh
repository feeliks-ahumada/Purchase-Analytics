#!/bin/bash
#
# Use this shell script to compile (if necessary) your code and then execute it. Below is an example of what might be found in this file if your program was written in Python
#
#python ./src/purchase_analytics.py ./input/order_products.csv ./input/products.csv ./output/counters.csv
mvn -f src/ package
echo 'Compilation: Success!'
echo 'Processing report..'
java -jar src/PurchaseAnalytics-1.0-SNAPSHOT.jar "input/order_products.csv" "input/products.csv" > output/counters.csv
echo 'Done!'
