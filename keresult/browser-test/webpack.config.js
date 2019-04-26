var HtmlWebPackPlugin = require("html-webpack-plugin");

var path = require("path");

module.exports = {
    entry: './index.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'index.js'
    },
    resolve: {
        modules: [path.resolve(__dirname, '../build/dist'), 'node_modules']
    },
    module: {
        rules: []
    },
    watch: true,
    plugins: [new HtmlWebPackPlugin({template: 'index.ejs'})]
};