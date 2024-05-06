from flask import Flask, request, jsonify
import pandas as pd
import pickle
from preprocessing import preprocess_data

app = Flask(__name__)

# Load the trained classifier
with open('classifier.pkl', 'rb') as f:
    classifier = pickle.load(f)

# Define route to accept POST requests with JSON data
@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    features = pd.DataFrame.from_dict(data, orient='index').T
    prediction = classifier.predict(features)
    return jsonify({'prediction': int(prediction)})

if __name__ == '__main__':
    app.run(debug=True)