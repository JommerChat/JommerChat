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

app.listen(port, () => {
  console.log('Express Mock Web Server listening at port: ' + port);
})
