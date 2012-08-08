--Primary Keys
CREATE INDEX IF NOT EXISTS PK_Users ON Users (Id);
CREATE INDEX IF NOT EXISTS PK_DiceRule ON DiceRule (Id);

--Foreign Keys
CREATE INDEX IF NOT EXISTS FK_DiceRule_Users ON DiceRule (OwnerId);
CREATE INDEX IF NOT EXISTS FK_RuleParam_DiceRule ON RuleParam (DiceRuleId);

--Other
CREATE UNIQUE INDEX IF NOT EXISTS Users_Name ON Users (Name);	--Quick username search