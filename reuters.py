import matplotlib.pyplot as plt
import tensorflow_datasets as tfds
import tensorflow as tf
import numpy as np
from tensorflow import keras

#获取数据集 参数num_words = 10000 表示数据集将会保留出现频率在前10000的单词
(x_train, y_train), (x_test, y_test) = keras.datasets.reuters.load_data(path="reuters.npz",num_words=1000)
print()
print("训练集和测试集数量",len(x_train),len(x_test))
print("最初的测试集新闻文本\n",x_test)
print("长度为",len(x_test))
print("最初的测试集新闻标签\n",y_test)
print("长度为",len(y_test))
print(x_train.shape)

word_index = keras.datasets.reuters.get_word_index()# 单词--下标 对应字典
reverse_word_index = dict([(value, key) for (key, value) in word_index.items()])# 下标-单词对应字典
decoded_newswire = ' '.join([reverse_word_index.get(i - 3, '?') for i in x_train[0]])


print(decoded_newswire)

#将训练集和测试集的新闻文本向量化 即前一万个单词出现的为1 没出现的为0
def vectorize_sequences(sequences,dimension=1000):
    results=np.zeros((len(sequences),dimension))
    for i,sequence in enumerate(sequences):
        results[i,sequence]=1.
    return results
#将新闻文本全部转化为由1和0 组成的序列
x_train =vectorize_sequences(x_train)
x_test=vectorize_sequences(x_test)
print("向量化后的测试新闻文本\n",x_test)
print("长度为",len(x_test))

#将训练集和测试集的label转化为one-hot 标签由46个类别，同理将其转为1和0组成的序列
one_hot_train_labels = keras.utils.to_categorical(y_train)
one_hot_test_labels = keras.utils.to_categorical(y_test)

'''
def to_one_hot(labels, dimension=46):# 46个类别
    results = np.zeros((len(labels), dimension))
    for i, label in enumerate(labels):
        results[i, label] = 1.
    return results
one_hot_train_labels = to_one_hot(y_train)
one_hot_test_labels = to_one_hot(y_test)
'''
print("one—hot后的测试集新闻标签\n",one_hot_test_labels)
print("长度为",len(one_hot_test_labels))

#验证集，训练集中分出后1000个作为测试集
x_val = x_train[:100]
partial_x_train = x_train[100:]
y_val = one_hot_train_labels[:100]
partial_y_train = one_hot_train_labels[100:]
'''
#后一层网络神经元数目为46.意味着每个输入样本最终变成46维的向量。输出向量的每个数表示不同的类别；
#最后一层网络使用softmax激活函数–网络会输出一个46类的概率分布。每个输入最终都会产生一个46维的向量，每个数表示属于该类别的概率，46个数加起来等于1
model = tf.keras.models.Sequential()

model.add(tf.keras.layers.Embedding(len(x_train), 64))
model.add(keras.layers.Dense(64,  activation='relu', input_shape=(10000,)))
model.add(keras.layers.Dense(64, activation='relu'))
model.add(keras.layers.Dense(46, activation='softmax'))

model.compile(optimizer='rmsprop',loss='categorical_crossentropy', metrics=['accuracy'])
history = model.fit(partial_x_train,partial_y_train,epochs=20,batch_size=512,validation_data=(x_val, y_val))

model = tf.keras.Sequential()
model.add(keras.Embedding(10000, 128, input_length=maxlen))
model.add(Bidirectional(LSTM(64)))
model.add(Dropout(0.5))
model.add(Dense(1, activation='sigmoid'))

print(x_train.shape)
print(y_train.shape)

print(x_test.shape)
print(y_test.shape)
print(x_val.shape)
print(y_val.shape)
'''
#定义一个lstm模型
'''
input_dim：这是文本数据中词汇的取值可能数。例如，如果您的数据是整数编码为0-9之间的值，那么词汇的大小就是10个单词；
output_dim：这是嵌入单词的向量空间的大小。它为每个单词定义了这个层的输出向量的大小。例如，它可能是32或100甚至更大，可以视为具体问题的超参数；
input_length：这是输入序列的长度，就像您为Keras模型的任何输入层所定义的一样，也就是一次输入带有的词汇个数。例如，如果您的所有输入文档都由1000个字组成，那么input_length就是1000。
'''
def lstm_model():
    model = keras.Sequential([
        #嵌入层用于降维处理
    tf.keras.layers.Embedding(input_dim=1000, output_dim=64, input_length=1000),
        #一个双层双向Lstm
    tf.keras.layers.Bidirectional(tf.keras.layers.LSTM(64, return_sequences=True)),
    tf.keras.layers.Bidirectional(tf.keras.layers.LSTM(32)),
    tf.keras.layers.Dense(64, activation='relu'),
        #softmax 可用在logistic回归模型在多分类问题上的推广
    tf.keras.layers.Dense(46, activation='softmax')
])
    model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])
    return model

model = lstm_model()

model.summary()
Model: "sequential_2"
history = model.fit(partial_x_train,partial_y_train,epochs=20,batch_size=64,validation_data=(x_val, y_val))
