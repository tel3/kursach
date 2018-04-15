import axios from 'axios'

export function login (login, password) {
  axios.post('/login', {
    email: login,
    password: password
  })
    .then(function (response) {
      console.log(response)
    })
    .catch(function (error) {
      console.log(error)
    })
}
