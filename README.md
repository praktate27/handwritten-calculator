# handwritten-calculator

Project is done to demonstrate K-NN Supervised Machine Learning Algorithm using Python and Java used for recongnising handwritten numbers and calculate based on operation.

Java is used for following things :

    1. To create a GUI for the calculator. It contains several buttons and text-veiws.
    2. To do the calculation, when user clicks "=".
    3. To run the python file and get its result.
    
Python is used for following :

    1. To Do the handwriting recognition. 
    
Data is taken from :
  
    1. http://yann.lecun.com/exdb/mnist/
    
What is KNN algorithm?

    KNN is a non-parametric, lazy learning algorithm. Its purpose is to use a database in which the data points are separated into several classes to predict the classification of a new sample point. Non-parametric means it does not make any assumptions based on underlying data distribution. In simple words, the model structure is determined from data. Lazy means it does not use the training data points to do any generalization. In other words, there is no explicit training phase or it is very minimal. It is based on feature similarity. 
    In this algorithm, An object is classified by a majority vote of its neighbors, with the object being assigned to the class most common among its k nearest neighbors. To find out nearest neighbor, most of time Euclidian Distance is used.
    
Pros:
    
    1. No assumptions about data — useful, for example, for nonlinear data
    2. Simple algorithm — to explain and understand/interpret
    3. High accuracy (relatively) — it is pretty high but not competitive in comparison to better supervised learning models
    4. Versatile — useful for classification or regression

Cons:

    1. Computationally expensive — because the algorithm stores all of the training data
    2. High memory requirement
    3. Stores all (or almost all) of the training data
    4. Prediction stage might be slow (with big N)
    5. Sensitive to irrelevant features and the scale of the data
    


    
