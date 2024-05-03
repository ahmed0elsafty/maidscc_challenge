from flask import Flask, request, jsonify
import pandas as pd
import pickle

app = Flask(__name__)

# Load the trained classifier
with open('classifier.pkl', 'rb') as f:
    classifier = pickle.load(f)

# Define route to accept POST requests with JSON data
@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    features = pd.DataFrame(data, index=[0])
    prediction = classifier.predict(features)
    return jsonify({'prediction': int(prediction)})

if __name__ == '__main__':
    app.run(debug=True)