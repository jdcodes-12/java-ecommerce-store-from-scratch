import { UserConfig, RuleConfigSeverity } from '@commitlint/types';

const { Error, Warning, Disabled } = RuleConfigSeverity;

const Configuration: UserConfig = {
  extends: ['@commitlint/config-conventional'],
  formatter: '@commitlint/format',
  /*
   * Any rules defined here will override rules from @commitlint/config-conventional
   */
  rules: {
    'header-case': [Warning, 'always', 'start-case'],
    'header-full-stop': [Error, 'never', '.'],
    'header-max-length': [Error, 'always', 72],
    'header-min-length': [Error, 'always', 0],
    'body-full-stop': [Error, 'always', '.'],
    'body-leading-blank': [Error, 'always'],
    'body-empty': [Error, 'never'],
    'body-max-length': [Error, 'always', 1000],
    'body-max-line-length': [Warning, 'always', 100],
    'body-case': [Error, 'always', 'sentence-case'],
    'footer-leading-blank': [Error, 'always'],
    'footer-empty': [Disabled, 'always'],
    'footer-max-length': [Disabled, 'always', 72],
    'scope-case': [Error, 'always', 'lower-case'],
    'scope-empty': [Warning, 'never'],
    'scope-max-length': [Warning, 'always', 36],
    'scope-min-length': [Error, 'always', 0],
    'scope-enum': [Warning, 'always', [
      'module', 'feature', 'service', 'setup', 'misc',
      'refactor'
    ]],
    'subject-case': [Warning, 'always', 'start-case'],
    'subject-empty': [Error, 'never'],
    'subject-full-stop': [Error, 'never', '.'],
    'subject-min-length': [Error, 'always', 5],
    'subject-exclamation-mark': [Warning, 'never'],
    'type-enum': [Error, 'always',[
      'ADD', 'FIX', 'PM', 'CQ'
    ]],
    'type-case': [Error, 'always', 'upper-case'],
    'type-empty': [Error, 'never'],
    'type-max-length': [Error, 'always', 7],
    'type-min-length': [Error, 'always', 0]
  },
  defaultIgnores: true,
  helpUrl: 'https://github.com/conventional-changelog/commitlint/#what-is-commitlint',
};

module.exports = Configuration;
