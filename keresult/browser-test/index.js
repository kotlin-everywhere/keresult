mocha.setup('bdd');
mocha.checkLeaks();

require('keresult_test');

mocha.run();
