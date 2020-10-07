import axios from 'axios'

const COURSE_API_URL = 'http://localhost:8080'

class ArquivoDataService {

    search(form) {
        //console.log('executed service')
        return axios.post(`${COURSE_API_URL}/arquivos`,form);
    }
        
}

export default new ArquivoDataService()