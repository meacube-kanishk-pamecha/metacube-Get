//server.js
const express = require('express')
const path = require('path');
const app = express()
const port = 3000

//  shows them the homepage (index.html) from the public
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, './public/index.html'));
})

app.listen(port, () => {
  console.log(`App listening on port ${port}`)
})