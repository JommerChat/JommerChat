const express = require('express');
const fs = require('fs');
const app = express();
const port = 8080;
const baseUrl = '/guild';
const cors = require('cors');

app.use(cors());

app.get(`${baseUrl}/initialInfo`, async (req, resp) => {
  const initialInfo = JSON.parse(fs.readFileSync('/home/bressette/git/parlantos/LocalServer/initialInfo.json'));
  resp.json(initialInfo);
});

app.get(`${baseUrl}/fetchGuilds`, async(req, resp) => {
  const fetchGuilds = JSON.parse(fs.readFileSync('/home/bressette/git/parlantos/LocalServer/MembersGuilds.json'));
  resp.json(fetchGuilds);
});

app.listen(port, () => {
  console.log('Express Mock Web Server listening at port: ' + port);
})
