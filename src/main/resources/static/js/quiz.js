document.addEventListener('DOMContentLoaded', function () {

// Fonction pour ajouter une div "response"
    function addResponse() {
        const responsesDiv = this.parentElement;
        const responseCount = responsesDiv.querySelectorAll('.response').length;
        const newResponseDiv = document.createElement('div');
        newResponseDiv.classList.add('response');
        newResponseDiv.innerHTML = `
            <label for="response-${responseCount + 1}-${responseCount + 1}"> Answer ${responseCount + 1}</label>
            <input type="checkbox">
            <input type="text" name="response" id="response-${responseCount + 1}-${responseCount + 1}" class="text-input mid-input">
            <button class="deleteResponse" type="button"> X </button>
        `;
        responsesDiv.insertBefore(newResponseDiv, this);
        updateDeleteResponseButtons();
    }

    // Fonction pour ajouter une div "question"
    function addQuestion() {
        const questionsDiv = this.parentElement;
        const questionCount = questionsDiv.children.length - 1; // Exclut le bouton "addQuestion"
        const newQuestionDiv = document.createElement('div');
        newQuestionDiv.classList.add('question');
        newQuestionDiv.innerHTML = `
            <label for="question-${questionCount + 1}"> Question ${questionCount + 1} </label>
            <input type="text" name="question" id="question-${questionCount + 1}" class="text-input big-input">
            <button class="deleteQuestion" type="button"> X </button>
            <div class="responses">
                <div class="response">
                    <label for="response-${questionCount + 1}-1"> Answer 1</label>
                    <input type="checkbox">
                    <input type="text" name="response" id="response-${questionCount + 1}-1" class="text-input mid-input">
                    <button class="deleteResponse" type="button"> X </button>
                </div>
                <div class="response">
                    <label for="response-${questionCount + 1}-2"> Answer 2</label>
                    <input type="checkbox">
                    <input type="text" name="response" id="response-${questionCount + 1}-2" class="text-input mid-input">
                    <button class="deleteResponse" type="button"> X </button>
                </div>
                <button class="addAnswer" type="button"> + Add answers </button>
            </div>
        `;
        questionsDiv.insertBefore(newQuestionDiv, this);
        updateDeleteQuestionButtons();
        updateDeleteResponseButtons();
        updateAddAnswerButtons();
    }

    // Fonction pour supprimer la réponse associée
    function deleteResponse() {
        const responseDiv = this.parentElement;
        const responsesDiv = responseDiv.parentElement;
        const responseCount = responsesDiv.querySelectorAll('.response').length;

        // Supprimer la réponse
        responseDiv.remove();
        updateDeleteResponseButtons();

        // Mettre à jour la numérotation des réponses
        responsesDiv.querySelectorAll('.response').forEach((response, index) => {
            const label = response.querySelector('label');
            const input = response.querySelector('input[type="text"]');
            const button = response.querySelector('.deleteResponse');

            label.setAttribute('for', `response-${index + 1}-${index + 1}`);
            label.textContent = `Answer ${index + 1}`;

            input.setAttribute('id', `response-${index + 1}-${index + 1}`);
            button.dataset.responseIndex = index + 1;
        });
    }

    // Fonction pour supprimer la question associée
    function deleteQuestion() {
        this.parentElement.remove();
        updateDeleteQuestionButtons();
    }

    // Fonction pour mettre à jour les boutons "deleteResponse"
    function updateDeleteResponseButtons() {
        const deleteResponseButtons = document.querySelectorAll('.deleteResponse');
        deleteResponseButtons.forEach(button => {
            button.addEventListener('click', deleteResponse);
        });
    }

    // Fonction pour mettre à jour les boutons "deleteQuestion"
    function updateDeleteQuestionButtons() {
        const deleteQuestionButtons = document.querySelectorAll('.deleteQuestion');
        deleteQuestionButtons.forEach(button => {
            button.addEventListener('click', deleteQuestion);
        });
    }

    // Fonction pour mettre à jour les boutons "addAnswer"
    function updateAddAnswerButtons() {
        const addAnswerButtons = document.querySelectorAll('.addAnswer');
        addAnswerButtons.forEach(button => {
            button.addEventListener('click', addResponse);
        });
    }

    // Ajout des écouteurs d'événements pour les boutons existants
    updateDeleteResponseButtons();
    updateDeleteQuestionButtons();
    updateAddAnswerButtons();

    // Ajout d'un écouteur d'événement pour le bouton "addQuestion"
    const addQuestionButton = document.querySelector('.addQuestion');
    addQuestionButton.addEventListener('click', addQuestion);
});
