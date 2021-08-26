from pyspark import SparkConf,SparkContext

conf = SparkConf().setMaster("local").setAppName("myApp")
sc = SparkContext(conf=conf)

word_counts = []
for file_name in [0,1,2]:
    text_file = sc.textFile(f"texts/{file_name}.txt")
    word_count = text_file.flatMap(lambda line: line.split(" ")) \
        .map(lambda word: (word, 1)) \
        .reduceByKey(lambda a, b: a + b) \
        .mapValues(lambda x: (file_name, x))
    word_counts.append(word_count)

file_counts = word_counts[0].union(word_counts[1])\
                            .union(word_counts[2])\
                            .groupByKey()\
                            .mapValues(list)

for k,v in file_counts.collect():
    print(k,v)