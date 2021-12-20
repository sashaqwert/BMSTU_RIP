import axios from "axios";

export const getFromServer = (url) => {
    return axios.get(url).then((res) => res.data).catch((msg) => alert(msg));
};
