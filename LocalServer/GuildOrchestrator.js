const express = require('express');
const fs = require('fs');
const app = express();
const port = 8080;
const baseUrl = '/guild';
const cors = require('cors');
const bodyParser = require('body-parser');
const multer = require('multer');
const upload = multer();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// app.use(upload.array());
app.use(express.static('public'));
app.use(cors());

app.get(`${baseUrl}/initialInfo`, async (req, resp) => {
  const initialInfo = JSON.parse(fs.readFileSync('/Users/johnathanbressette/Documents/git/JommerChat/LocalServer/initialInfo.json'));
  resp.json(initialInfo);
});

app.get(`${baseUrl}/fetchGuilds`, async(req, resp) => {
  const fetchGuilds = JSON.parse(fs.readFileSync('/Users/johnathanbressette/Documents/git/JommerChat/LocalServer/MembersGuilds.json'));
  resp.json(fetchGuilds);
});

app.get(`${baseUrl}/fetchServerCards`, async(req, resp) => {
  const fetchGuilds = JSON.parse(fs.readFileSync('/Users/johnathanbressette/Documents/git/JommerChat/LocalServer/MembersGuilds.json'));
  resp.json(fetchGuilds);
});

app.post(`${baseUrl}/createServer`, async(req, resp) => {
  const initialInfo = JSON.parse(fs.readFileSync('/Users/johnathanbressette/Documents/git/JommerChat/LocalServer/initialInfo.json'));
  initialInfo.id = (Math.floor(Math.random() * 1000)).toString();
  resp.json(initialInfo);
});

app.listen(port, () => {
  console.log('Express Mock Web Server listening at port: ' + port);
})
