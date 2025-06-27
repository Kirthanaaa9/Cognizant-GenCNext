/*Scenario 1: ProcessMonthlyInterest — Apply 1% Interest*/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
    UPDATE Accounts
    SET Balance = Balance + (rec.Balance * 0.01)
    WHERE AccountID = rec.AccountID;
  END LOOP;
  COMMIT;
END;



/*Scenario 2: UpdateEmployeeBonus — Add Bonus to Salary*/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_dept_id IN Employees.DepartmentID%TYPE,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * (p_bonus_percent / 100))
  WHERE DepartmentID = p_dept_id;
  COMMIT;
END;



/*Scenario 3: TransferFunds — Transfer Amount Between Accounts*/

CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN Accounts.AccountID%TYPE,
  p_to_account IN Accounts.AccountID%TYPE,
  p_amount IN NUMBER
) IS
  v_balance NUMBER;
BEGIN
  -- Get source account balance
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = p_from_account
  FOR UPDATE;

  -- Check for sufficient balance
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account');
  END IF;

  -- Deduct from source account
  UPDATE Accounts
  SET Balance = Balance - p_amount
  WHERE AccountID = p_from_account;

  -- Add to destination account
  UPDATE Accounts
  SET Balance = Balance + p_amount
  WHERE AccountID = p_to_account;

  COMMIT;
END;
