import axios, { AxiosRequestConfig } from 'axios';

export const BASE_URL = 'http://localhost:8080';

export const requestBackend = (config: AxiosRequestConfig) => {
  const headers = config.headers;

  return axios({ ...config, baseURL: BASE_URL, headers });
};

// Add a request interceptor
axios.interceptors.request.use(
  function (config) {
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);
