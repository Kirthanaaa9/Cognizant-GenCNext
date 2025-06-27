/*Scenario 1: Apply 1% Discount to Interest Rates for Customers Over 60*/
     BEGIN
  FOR rec IN (SELECT CustomerID, InterestRate FROM Customers WHERE Age > 60) LOOP
    UPDATE Customers
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = rec.CustomerID;
  END LOOP;
  COMMIT;
END;



/*Scenario 2: Promote Customers with Balance Over $10,000 to VIP*/
   BEGIN
  FOR rec IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = rec.CustomerID;
  END LOOP;
  COMMIT;
END;


/*Scenario 3: Send Reminders for Loans Due in Next 30 Days*/
    DECLARE
  v_due_date Loans.DueDate%TYPE;
  v_customer_id Loans.CustomerID%TYPE;
BEGIN
  FOR rec IN (
    SELECT LoanID, CustomerID, DueDate
    FROM Loans
    WHERE DueDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID ||
                         ' for Customer ID ' || rec.CustomerID ||
                         ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
  END LOOP;
END;
