package com.example.employeesurveryapp.data.database

@Database(
    entities = [
        User::class,
        Role::class,
        Survey::class,
        SurveyYear::class,
        Question::class,
        QuestionType::class,
        QuestionOption::class,
        SurveyAssignment::class,
        Answer::class,
        Notification::class,
        FeedbackMessage::class,
        AuditLog::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun surveyDao(): SurveyDao

}