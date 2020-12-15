
const client = filestack.init(fileStackApiKey);
let callback;

const options = {
    onFileUploadFinished: callback => {
        console.log(callback.url);
        callback = callback;
        $("#image").val(callback.url);
        $("#imagePreview").attr("src", callback.url);
    }
}

$("#addPicture").click(function(e){
    e.preventDefault();
    client.picker(options).open();
});

