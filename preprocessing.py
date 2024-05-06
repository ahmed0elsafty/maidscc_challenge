import numpy as np

def preprocess_data(data):
    data['power_efficiency'] = data['battery_power'] * data['talk_time']
    data['total_camera_quality'] = data['fc'] + data['pc']
    data['total_pixel_resolution'] = data['px_height'] * data['px_width']
    data['total_screen_size'] = data['sc_h'] * data['sc_w']
    data['mobile_size_index'] = data['mobile_wt'] + data['m_dep']
    if 'id' in data.columns:
        data.drop(['id'], axis=1, inplace=True)
    data.drop(['four_g','battery_power', 'talk_time', 'fc', 'pc', 'px_height', 'mobile_wt', 'm_dep',
               'px_width', 'sc_h', 'sc_w'], axis=1, inplace=True)
    data['power_efficiency'] = np.sqrt(data['power_efficiency'])
    data['total_camera_quality'] = np.sqrt(data['total_camera_quality'])
    data['total_pixel_resolution'] = np.sqrt(data['total_pixel_resolution'])
    data['total_screen_size'] = np.sqrt(data['total_screen_size'])
    return data
