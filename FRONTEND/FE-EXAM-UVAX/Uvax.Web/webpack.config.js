const path = require('path');
module.exports = {
    entry: './src/Uvax.js',
    output: {
        filename: 'main.js',
        path: path.resolve(__dirname, 'wwwroot/js'),
    },
};