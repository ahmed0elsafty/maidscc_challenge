import mysql.connector
from mysql.connector import Error
import pandas as pd

# MySQL database connection parameters
DB_USER = 'root'
DB_PASSWORD = 'password'
DB_HOST = '127.0.0.1'
DB_NAME = 'Maidscc'

def load_test_data_to_mysql():
    # Test dataframe
    test_data = pd.read_csv('test.csv')  
    # Define the connection variable outside the try block
    connection = None

    try:
        # Connect to MySQL database
        connection = mysql.connector.connect(host=DB_HOST,
                                             database=DB_NAME,
                                             user=DB_USER,
                                             password=DB_PASSWORD)

        if connection.is_connected():
            db_info = connection.get_server_info()
            print("Connected to MySQL Server version ", db_info)

            cursor = connection.cursor()

            # Create table
            create_table_query = """
            CREATE TABLE IF NOT EXISTS test_data (
                id INT AUTO_INCREMENT PRIMARY KEY,
                battery_power INT,
                blue INT,
                clock_speed FLOAT,
                dual_sim INT,
                fc INT,
                four_g INT,
                int_memory INT,
                m_dep FLOAT,
                mobile_wt INT,
                n_cores INT,
                pc INT,
                px_height INT,
                px_width INT,
                ram INT,
                sc_h INT,
                sc_w INT,
                talk_time INT,
                three_g INT,
                touch_screen INT,
                wifi INT
            )
            """

            cursor.execute(create_table_query)
            print("Table 'test_data' created successfully.")

            # Insert data into table
            for index, row in test_data.iloc[:, 1:].iterrows():
                insert_query = """
                INSERT INTO test_data (
                    battery_power, blue, clock_speed, dual_sim, fc, four_g, int_memory, m_dep, 
                    mobile_wt, n_cores, pc, px_height, px_width, ram, sc_h, sc_w, talk_time, 
                    three_g, touch_screen, wifi
                ) 
                VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
                """
                record = tuple(row)
                cursor.execute(insert_query, record)

            connection.commit()
            print("Data inserted into the table successfully.")

    except Error as e:
        print("Error while connecting to MySQL:", e)

    finally:
        # Close database connection
        if connection is not None and connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed.")

if __name__ == "__main__":
    load_test_data_to_mysql()
